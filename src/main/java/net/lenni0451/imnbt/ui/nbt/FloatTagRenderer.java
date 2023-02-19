package net.lenni0451.imnbt.ui.nbt;

import imgui.ImGui;
import imgui.type.ImFloat;
import net.lenni0451.imnbt.ui.types.TagRenderer;
import net.lenni0451.mcstructs.nbt.INbtTag;
import net.lenni0451.mcstructs.nbt.tags.FloatTag;

import javax.annotation.Nonnull;
import java.text.DecimalFormat;

public class FloatTagRenderer implements TagRenderer {

    private final DecimalFormat format = new DecimalFormat();

    @Override
    public void render(String name, @Nonnull INbtTag tag) {
        FloatTag floatTag = (FloatTag) tag;
        this.renderLeaf(name + ": " + this.format.format(floatTag.getValue()), tag.hashCode());
    }

    @Override
    public void renderValueEditor(INbtTag tag) {
        FloatTag floatTag = (FloatTag) tag;
        ImFloat value = new ImFloat(floatTag.getValue());
        if (ImGui.inputFloat("Value", value)) floatTag.setValue(value.get());
    }

}
