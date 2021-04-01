package org.seckill.test.spi.test;

import org.seckill.test.spi.UploadCDN;

import java.util.ServiceLoader;

/**
 * @author cgm
 * @create 2021-02-18 13:24
 */
public class Test {
	public static void main(String[] args) {
		ServiceLoader<UploadCDN> uploadCDN = ServiceLoader.load(UploadCDN.class);
		for (UploadCDN u : uploadCDN) {
			u.upload("filePath");
		}

	}

	//读取配置获取所有实现
	//private static ServiceLoader spiLoader = ServiceLoader.load(Spi.class);

	//根据名字选取对应实现
//	public static Spi getSpi(String name) {
//		for (Spi spi : spiLoader) {
//			if (spi.isSupport(name)) {
//				returnspi;
//			}
//		}
//		return null;
//	}
}
