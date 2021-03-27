package com.galaxy.utils;

import com.galaxy.entity.NhanVien;

public class Auth {

    public static NhanVien user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static String getName() {
        return user.getTenNV();
    }

    public static boolean isManager() {
        return Auth.isLogin() && user.getVaiTro();
    }
}
