package com.xk72.charles.gui.transaction.actions;

import javax.swing.text.JTextComponent;

/**
 * Created by sunxiaoyang@cmcm.com
 * 2021/12/30 14:39
 */
public class PangelAdComponent extends PangleAdUrlDecodeAction {
    private final JTextComponent component;

    public PangelAdComponent(JTextComponent var1) {
        super(var1);
        this.component = var1;
    }


    @Override
    protected String getBody() {
        String var1;
        if ((var1 = this.component.getSelectedText()) == null) {
            var1 = this.component.getText();
        }
        return var1;
    }
}
