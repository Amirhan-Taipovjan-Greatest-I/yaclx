package mod.crend.yaclx.render;

import dev.isxander.yacl3.gui.ImageRenderer;

import java.util.List;

public interface ListImageRenderer<T> extends ImageRenderer {
	void setList(List<T> list);
}
