package com.programku;

import test.util.Memasak;

// access modifier, contohnya kyk yg public2 di bawah ini
public class Main {
	public static void main(String[] args) {
		// public, private, default, dan protected

		// dengan access modifier public, dapat diaccess
		Lain.methodPublic();

		// dengan access modifier private, tidak dapat diaccess
		// Lain.methodPrivate();

		Lain.methodDefault();

		Lain.methodProtected();

		Memasak.dagingPublic();


	}


}