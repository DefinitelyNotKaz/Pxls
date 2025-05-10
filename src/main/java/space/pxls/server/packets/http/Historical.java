package space.pxls.server.packets.http;

import space.pxls.App;
import space.pxls.data.DBPixelPlacement;

public class Historical {
	public int id;
	public int x;
	public int y;
	
	public Historical(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public static Historical fromDB(int x, int y) {
		return Historical.fromDB(App.getDatabase().getPixelHistoryAt(x, y).orElse(null));
	}

	public static Historical fromDB(DBPixelPlacement pixelPlacement) {
		if (pixelPlacement == null) return null;
		return new Historical(pixelPlacement.id, pixelPlacement.x, pixelPlacement.y);
	}
}