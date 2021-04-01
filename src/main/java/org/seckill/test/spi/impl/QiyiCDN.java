package org.seckill.test.spi.impl;

import org.seckill.test.spi.UploadCDN;

/**
 * @author cgm
 * @create 2021-02-18 13:16
 */
public class QiyiCDN implements UploadCDN {
	@Override
	public void upload(String url) {
		System.out.println("upload to qiyi cdn");
	}
}
