package space.pxls.server.packets.http;

import space.pxls.App;
import space.pxls.data.DBPixelPlacement;

import java.util.List;
import java.util.Optional;
import java.util.Collections;


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
	    Optional<List<DBPixelPlacement>> pixelHistoryOpt = App.getDatabase().getPixelHistoryAt(x, y);
	    
	    return Historical.fromDB(pixelHistoryOpt.orElse(Collections.emptyList()));
	}


	public static Historical fromDB(DBPixelPlacement pixelPlacement) {
		if (pixelPlacement == null) return null;
		return new Historical(pixelPlacement.id, pixelPlacement.x, pixelPlacement.y);
	}
}