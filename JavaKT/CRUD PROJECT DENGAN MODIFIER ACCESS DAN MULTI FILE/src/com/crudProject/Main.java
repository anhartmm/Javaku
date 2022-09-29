package com.crudProject;

// import java library
import java.util.*;
import java.io.*;
import java.time.Year;

// import crudProject library
import com.crudProject.Operasi;
import com.crudProject.Utility;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean isLanjutkan = true;
		Utility.clearScreen();

		while(isLanjutkan == true) {
			Utility.menu();
			isLanjutkan = com.crudProject.Utility.isContinue("Kembali ke Menu",true);
		}
	}
}












