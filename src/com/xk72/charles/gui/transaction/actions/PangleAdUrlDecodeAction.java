package com.xk72.charles.gui.transaction.actions;

import com.google.gson.Gson;
import com.xk72.charles.CharlesContext;
import com.xk72.charles.gui.transaction.general.ToolUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public abstract class PangleAdUrlDecodeAction extends AbstractAction {

    private final Component source;

    protected PangleAdUrlDecodeAction(Component var1) {
        super("Pangle Ad Decode");
        this.source = var1;
    }

    protected abstract String getBody();

    @Override
    public void actionPerformed(ActionEvent paramActionEvent) {
        try {
            String body = getBody();
            if (body == null || body.isEmpty()) {
                CharlesContext.getInstance().error("Failed to get message, Body is null");
                return;
            }
            Gson gson = new Gson();
            Map map = gson.fromJson(body, Map.class);
            if (map == null) {
                return;
            }
            String message = null;
            if (map.containsKey("message")) {
                message = (String) map.get("message");
            } else if (map.containsKey("desc")) {
                message = (String) map.get("desc");
            }
            if (message != null && !message.isEmpty()) {
                String urlDecode = ToolUtils.decryption(message);
                if (urlDecode == null || urlDecode.isEmpty() || urlDecode.equals("null")) {
                    urlDecode = ToolUtils.decode(message);
                    if (urlDecode == null || urlDecode.isEmpty() || urlDecode.equals("null")) {
                        urlDecode = ToolUtils.decodeAdData(message);
                        WaringDialog("穿山甲广告解密3", urlDecode);
                    } else {
                        WaringDialog("穿山甲广告解密2", urlDecode);
                    }
                } else {
                    WaringDialog("穿山甲广告解密1", urlDecode);
                }
            } else {
                CharlesContext.getInstance().error("Failed to get message, Check the data");
            }
        } catch (Exception e) {
            e.printStackTrace();
            CharlesContext.getInstance().error("Failed to url decode. Probably not valid");
        }

    }

    //避免影响原功能，所以新弹出一个窗口展示结果更为合适
    public void WaringDialog(String title, String content) {
        JFrame JFrame = new JFrame(title);
        JFrame.setPreferredSize(new Dimension(800, 500));
        JTextArea textArea = new JTextArea();
        textArea.setText(content + "\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane jScrollPane = new JScrollPane(textArea);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane.setAutoscrolls(false);
        JFrame.setContentPane(jScrollPane);
        JFrame.pack();
        JFrame.setVisible(true);
    }

}
