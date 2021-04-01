package com.alibaba.alibole;

/**
 * @author cgm
 * @create 2021-03-20 16:53
 */
public class DDD {
	public static void main(String[] args) {
		int n = 4;
		//cin >> n;
		int price[] = {20, 66, 8, 42};
		int r[] = new int[n + 1];

		for (int i = 0; i <= n; ++i) {
			r[i] = 0;  //初始化
		}


		for (int i = 1; i <= n; ++i)//规模长度为i
		{
			int q = Integer.MIN_VALUE;
			for (int j = 1; j <= i; ++j)//计算规模为i的最大收益
			{
				if (q < (price[j] + r[i - j]))//因为i>i-j，所以当计算r[i]时，r[i-j]已经解决，可以直接用
					q = (price[j] + r[i - j]);  //迭代q；
			}
			r[i] = q;  //找出i这个位置的最优解；
		}
		System.out.println(r[n]);
		//最后是n这个位置，就是n米长的木头的最大价值。
	}
}
