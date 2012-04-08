package com.sixcodes.uploader;

public class Convert {

	private static final int KB = 1024;
	private static final int MB = KB*KB;
	private static final int GB = MB*KB;

	public String convertToMb(long bytes) {
		if (bytes < KB) {
			return String.valueOf(bytes)+ " bytes";
		} else if(bytes < GB){
			return String.valueOf(bytes / MB) + " Mb";
		}else{
			return String.valueOf(bytes / GB) + " Gb";
		}
	}
}
