package mod.crend.yaclx.test;

import dev.isxander.yacl3.gui.ImageRenderer;
import mod.crend.yaclx.auto.annotation.DescriptionImage;
import mod.crend.yaclx.auto.annotation.Listener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TestDescriptionImageRenderer implements ImageRenderer {
	public static Formatting formatting;
	private final TestEnum value;
	public TestDescriptionImageRenderer(TestEnum value) {
		this.value = value;
	}

	@Override
	public int render(DrawContext graphics, int x, int y, int renderWidth) {
		graphics.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(value.toString()).formatted(formatting), x, y, 0x000000FF, true);
		return 16;
	}

	@Override
	public void close() { }

	public static class Factory implements DescriptionImage.DescriptionImageRendererFactory<TestEnum> {

		@Override
		public ImageRenderer create(TestEnum value) {
			return new TestDescriptionImageRenderer(value);
		}
	}

	public static class Callback implements Listener.Callback {
		public void accept(String key, Object value) {
			TestEnum enumValue = (TestEnum) value;
			formatting = switch(enumValue) {
				case DEFAULT -> Formatting.AQUA;
				case VALUE -> Formatting.GOLD;
				case MAGIC -> Formatting.DARK_PURPLE;
				case DIFFERENT -> Formatting.BLUE;
			};
		}
	}
}
