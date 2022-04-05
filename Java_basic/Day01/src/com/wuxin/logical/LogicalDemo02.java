package com.wuxin.logical;

/*
	位运算符：位运算符一定是先把数据转成二进制，然后再运算。
	面试题：&和&&的区别?
			A:&和&&都可以作为逻辑运算，&&具有短路效果。
			B:&还可以作为位运算。
*/
/**
 * @Author: wuxin001
 * @Date: 2022/03/19/21:56
 * @Description:
 */
public class LogicalDemo02 {
    public static void main(String[] args) {
        //&,|,^,~
        int a = 10;
        int b = 3;
        int c = 30;
        System.out.println(a & a);
        System.out.println(a & b); // 2
        System.out.println(a | b); //11
        System.out.println(a ^ b); //9
        System.out.println(~c); // -4
    }
}

/*
	A:计算出3，4的二进制
		10的二进制：00000000 00000000 00000000 000001010
		4 的二进制：00000000 00000000 00000000 00000100
	B:位&运算	有0则0
		00000000 00000000 00000000 00001010
	   &00000000 00000000 00000000 00000011
	   ------------------------------------
	    00000000 00000000 00000000 00000010 ->2
	C:位|运算	有1则1
		00000000 00000000 00000000 00001010
	   &00000000 00000000 00000000 00000011
	   ------------------------------------
	    00000000 00000000 00000000 00001011 -> 11
	D:位^运算	相同则0，不同则1
		00000000 00000000 00000000 00001010
	   &00000000 00000000 00000000 00000011
	   ------------------------------------
	    00000000 00000000 00000000 00001001 -> 9
	E:位~运算 把数据每个位都按位取反
		00000000 00000000 00000000 00001010
	   ~11111111 11111111 11111111 11110101
	 反:11111111 11111111 11111111 11110101
	 原:- 10000000 00000000 00000000 00001010


	 00000000 00000000 00000000 00011110
	 11111111 11111111 11111111 11100001
	 -00000000 00000000 00000000 00011110
*/