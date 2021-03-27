/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.galaxy.utils;

import com.galaxy.entity.DanhMucBean;
import com.galaxy.ui.GiaoDienThanhToan1;
import com.galaxy.ui.HoaDonJdialog1;
import com.galaxy.ui.KhachhangJdialog1;
import com.galaxy.ui.LoaiHangJdialog1;
import com.galaxy.ui.NhaCungCapJdialog1;
import com.galaxy.ui.NhanVienJdialog1;
import com.galaxy.ui.SanPhamJdialog1;
import com.galaxy.ui.TrangChu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class ChuyenMangHinhtroller {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;

    public ChuyenMangHinhtroller(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(247, 167, 77));
        jlbItem.setBackground(new Color(247, 167, 77));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChu());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }

    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChu();
                    break;
                case "HoaDon":
                    node = new HoaDonJdialog1();
                    break;
                case "LoaiHang":
                    node = new LoaiHangJdialog1();
                    break;
                case "SanPham":
                    node = new SanPhamJdialog1();
                    break;
                case "NhanVien":
                    node = new NhanVienJdialog1();
                    break;
                case "KhachHang":
                    node = new KhachhangJdialog1();
                    break;
                case "NhaCungCap":
                    node = new NhaCungCapJdialog1();
                    break;
                case "ThanhToan":
                    node = new GiaoDienThanhToan1();
                    break;

            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(247, 167, 77));
            jlbItem.setBackground(new Color(247, 167, 77));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(247, 167, 77));
            jlbItem.setBackground(new Color(247, 167, 77));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(240, 240, 240));
                jlbItem.setBackground(new Color(240, 240, 240));
            }
        }

    }

    private void setChangeBackgroud(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(247, 167, 77));
                item.getJlb().setBackground(new Color(247, 167, 77));
            } else {
                item.getJpn().setBackground(new Color(240, 240, 240));
                item.getJlb().setBackground(new Color(240, 240, 240));

            }
        }
    }
}
