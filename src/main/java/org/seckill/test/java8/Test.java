package org.seckill.test.java8;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author cgm
 * @create 2021-03-10 16:21
 */
public class Test {
	public static void main(String[] args) {
		List<String> array =
				Lists.newArrayList(
						"2021-03-10 09:32:24.637 [DubboServerHandler-10.250.86.114:20951-thread-221] [wms:ccUvu0wnaSAkq9fonIdXuAde113970] [] com.qccr.inventorycenter.traceLogWriter[TraceLogWriter.java:155]-[INFO] {\"appName\":\"inventorycenter\",\"attachments\":{},\"currentTimeMillis\":1615339944637,\"entryAppName\":\"\",\"entryName\":\"\",\"env\":\"prod\",\"insightRequestId\":\"wms:ccUvu0wnaSAkq9fonIdXuAde113970\",\"invokeChannel\":\"DUBBO_PROVIDER\",\"invokeLocalHost\":\"10.250.86.114\",\"invokeLocalPort\":0,\"invokeMethod\":\"com.qccr.inventorycenter.facade.service.businessinventory.SkuInvStockInOutFacade.stockout\",\"invokeRemoteHost\":\"10.250.106.100\",\"invokeRemotePort\":20844,\"invokeResult\":\"true\",\"params\":[{\"billNo\":\"LY21031009010757\",\"bizKey\":\"LY21031009010757\",\"detailList\":[{\"itemType\":0,\"kzSkuCode\":\"99289173\",\"quantity\":1,\"skuId\":289173,\"timeSerial\":\"1615339944637\"}],\"mediatorSystem\":\"wms\",\"sourceNo\":\"LY21031009010757\",\"stockOutTime\":1615339944623,\"stockOutType\":233,\"timeSerial\":\"1615339944637\",\"warehouseCode\":\"12280\"},\"WMS\"],\"project\":\"i0\",\"responseTime\":13,\"resultData\":{\"statusText\":\"出库失败,bizKey为LY21031009010757\",\"stateCode\":{\"code\":-52601118,\"desc\":\"出库失败\"}}}");
		array.forEach(source -> {
			source = test(source);


			source = source.replace(
					"{\"billNo\"",
					"{\"class\":\"com.qccr.inventorycenter.facade.request.mediator.StockOutRequest\",\"billNo\"");

			source = source.replace(
					"[{",
					"[{\"class\":\"com.qccr.inventorycenter.facade.request.mediator.StockOutDetailRequest\",");

			source = "invoke com.qccr.inventorycenter.facade.service.businessinventory.SkuInvStockInOutFacade.stockout(" + source;
			source = source + ",null)";
			// ;
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(source);
		});
//		String source =
//				"2021-03-10 11:48:02.559 [DubboServerHandler-10.250.84.168:20951-thread-239] [wms:9ssqiKGToAOqhu9ySQvK6wde340487] [] com.qccr.inventorycenter.traceLogWriter[TraceLogWriter.java:155]-[INFO] {\"appName\":\"inventorycenter\",\"attachments\":{},\"currentTimeMillis\":1615348082559,\"entryAppName\":\"\",\"entryName\":\"\",\"env\":\"prod\",\"insightRequestId\":\"wms:9ssqiKGToAOqhu9ySQvK6wde340487\",\"invokeChannel\":\"DUBBO_PROVIDER\",\"invokeLocalHost\":\"10.250.84.168\",\"invokeLocalPort\":0,\"invokeMethod\":\"com.qccr.inventorycenter.facade.service.businessinventory.SkuInvStockInOutFacade.stockout\",\"invokeRemoteHost\":\"10.250.104.112\",\"invokeRemotePort\":20844,\"invokeResult\":\"true\",\"params\":[{\"billNo\":\"LY21031011011064\",\"bizKey\":\"LY21031011011064\",\"detailList\":[{\"itemType\":0,\"kzSkuCode\":\"99237169\",\"quantity\":1,\"skuId\":237169,\"timeSerial\":\"1615348082559\"}],\"mediatorSystem\":\"wms\",\"sourceNo\":\"LY21031011011064\",\"stockOutTime\":1615348082544,\"stockOutType\":233,\"timeSerial\":\"1615348082559\",\"warehouseCode\":\"12280\"},\"WMS\"],\"project\":\"i0\",\"responseTime\":14,\"resultData\":{\"statusText\":\"出库失败,bizKey为LY21031011011064\",\"stateCode\":{\"code\":-52601118,\"desc\":\"出库失败\"}}}";

		//System.out.println("---------");
		//String source = "2021-03-10 12:00:03.211 [DubboServerHandler-10.250.74.4:20951-thread-247] [wms:a6IQzsXneT5zBsQ809fXlAde318801] [] com.qccr.inventorycenter.traceLogWriter[TraceLogWriter.java:155]-[INFO] {\"appName\":\"inventorycenter\",\"attachments\":{},\"currentTimeMillis\":1615348803211,\"entryAppName\":\"\",\"entryName\":\"\",\"env\":\"prod\",\"insightRequestId\":\"wms:a6IQzsXneT5zBsQ809fXlAde318801\",\"invokeChannel\":\"DUBBO_PROVIDER\",\"invokeLocalHost\":\"10.250.74.4\",\"invokeLocalPort\":0,\"invokeMethod\":\"com.qccr.inventorycenter.facade.service.businessinventory.SkuInvStockInOutFacade.stockout\",\"invokeRemoteHost\":\"10.250.87.119\",\"invokeRemotePort\":20844,\"invokeResult\":\"true\",\"params\":[{\"billNo\":\"LY21031012011075\",\"bizKey\":\"LY21031012011075\",\"detailList\":[{\"itemType\":0,\"kzSkuCode\":\"99237169\",\"quantity\":1,\"skuId\":237169,\"timeSerial\":\"1615348803211\"}],\"mediatorSystem\":\"wms\",\"sourceNo\":\"LY21031012011075\",\"stockOutTime\":1615348803195,\"stockOutType\":233,\"timeSerial\":\"1615348803211\",\"warehouseCode\":\"1175\"},\"WMS\"],\"project\":\"i0\",\"responseTime\":14,\"resultData\":{\"statusText\":\"出库失败,bizKey为LY21031012011075\",\"stateCode\":{\"code\":-52601118,\"desc\":\"出库失败\"}}}";

	}


	public static String test(String source) {
		source = source.substring(source.indexOf("\"params\":[") + 10, source.indexOf(",\"WMS\""));
		//System.out.println(source);
		return source;
	}
}
