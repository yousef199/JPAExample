package main;

import java.io.File;

import javax.imageio.stream.FileImageInputStream;

public class PhotoChooser {
	File f; 
	FileImageInputStream fs;
	byte[] bfile;
	public PhotoChooser(String path)throws Exception {
		f = new File(path);
		fs  = new FileImageInputStream(f);
		bfile = new byte[(int) f.length()];
		fs.read(bfile);
		fs.close();
	}
	public byte[] getImageBytes() {
		return bfile;
	}
}
