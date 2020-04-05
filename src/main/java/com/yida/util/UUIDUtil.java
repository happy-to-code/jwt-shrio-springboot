package com.yida.util;

import java.util.UUID;

/**
 * 功能描述: UUID生成
 *
 * @author zhangyifei
 * @date 2019/4/15 10:27
 */
public class UUIDUtil {

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

    /**
     * 获取UUID
     *
     * @return
     */
    public static String[] getUUID(int number) {
        String[] result = null;
        if (number > 0) {
            result = new String[number];
            for (int i = 0; i < number; i++) {
                result[i] = getUUID();
            }
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(getUUID());
	}

}
