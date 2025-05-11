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
    public List<DBPixelPlacement> placements;

    public Historical(int id, int x, int y, List<DBPixelPlacement> placements) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.placements = placements;
    }

    public static Historical fromDB(int x, int y) {
        Optional<List<DBPixelPlacement>> pixelHistoryOpt = App.getDatabase().getPixelHistoryAt(x, y);
        
        return fromDB(x, y, pixelHistoryOpt.orElse(Collections.emptyList()));
    }

    public static Historical fromDB(int x, int y, List<DBPixelPlacement> pixelHistory) {
        if (pixelHistory == null || pixelHistory.isEmpty()) {
            return new Historical(0, x, y, Collections.emptyList());
        }

        int historicalId = pixelHistory.get(0).id;
        
        return new Historical(historicalId, x, y, pixelHistory);
    }
}
