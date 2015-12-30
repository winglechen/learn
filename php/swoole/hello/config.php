<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 15/10/26
 * Time: 23:17
 */

class Config {
    private static $_data = [];

    public static function set($key, $value=0) {
        self::$_data[$key] = $value;
    }

    public static function get($key) {
        if (isset(self::$_data[$key])) {
            return self::$_data[$key];
        }

        return null;
    }

    public static function show() {
        return self::$_data;
    }
}