package com.zhaos.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class JunitTest {
	
//	@Test
//	public void test() throws Exception {
////		Document document = new Document();
////		PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Administrator/Desktop/行业报告/pdf/01.pdf"));
////		document.addTitle("Title@sample");
////		document.open();
////		document.add(new Paragraph("0"));
////		System.out.println(document.getPageSize());
////		document.close();
//
//		PDDocument document=PDDocument.load(new File("C:/Users/Administrator/Desktop/行业报告/pdf/01.pdf"));
//
//		PDDocumentInformation info = document.getDocumentInformation();
//		System.out.println("页数:"+document.getNumberOfPages());
//		System.out.println( "标题:" + info.getTitle() );
//		System.out.println( "主题:" + info.getSubject() );
//		System.out.println( "作者:" + info.getAuthor() );
//		System.out.println( "关键字:" + info.getKeywords() );
//		System.out.println( "应用程序:" + info.getCreator() );
//		System.out.println( "pdf 制作程序:" + info.getProducer() );
//		System.out.println( "Trapped:" + info.getTrapped() );
//		System.out.println( "创建时间:" + info.getCreationDate());
//		System.out.println( "修改时间:" + info.getModificationDate());
//
//		info.setTitle("001");
//		System.out.println( "标题:" + info.getTitle() );
//		document.setDocumentInformation(info);
//		document.close();
//	}
	
	
	public static void main(String[] args) {
//		openWinExe();
//		openExe();
//		openFile();
	}
	
	//用 Java 调用windows系统的exe文件，比如notepad，calc之类
	public static void openWinExe() {
		Runtime rn = Runtime.getRuntime();
		Process p = null;
		try {
			String command = "calc";
			p = rn.exec(command);
		} catch (Exception e) {
			System.out.println("Error win exec!");
		}
	}
	
	//调用其他的可执行文件，例如：自己制作的exe，或是 下载 安装的软件.
	public static void openExe() {
		Runtime rn = Runtime.getRuntime();
		Process p = null;
		try {
			p = rn.exec("D:\\Program Files (x86)\\AdeptPDF\\PDFInfo\\PDFInfo.exe");
		} catch (Exception e) {
			System.out.println("Error exec!");
		}
	}
	  
	// 打开其他任意格式的文件，比如txt,word等
	public static void openFile() {
		final Runtime runtime = Runtime.getRuntime();
		Process process = null;//
		final String cmd = "rundll32 url.dll FileProtocolHandler file://C:\\Users\\Administrator\\Desktop\\brand_brand_relation.sql";
		try {
			process = runtime.exec(cmd);
		} catch (final Exception e) {
			System.out.println("Error exec!");
		}
	}
	
}
