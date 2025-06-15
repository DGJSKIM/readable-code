package cleancode.minesweeper.tobe.cell;

import java.util.Objects;

public class CellSnapshot {

    private final CellSnapshotStatus status;
    private final int nearbyMineCount;

    private CellSnapshot(CellSnapshotStatus status, int nearbyMineCount) {
        this.status = status;
        this.nearbyMineCount = nearbyMineCount;
    }

    public static CellSnapshot of(CellSnapshotStatus status, int nearbyMineCount) {
        return new CellSnapshot(status, nearbyMineCount);
    }

    public static CellSnapshot ofEmpty(){
        return new CellSnapshot(CellSnapshotStatus.EMPTY, 0);
    }

    public static CellSnapshot ofFlag(){
        return new CellSnapshot(CellSnapshotStatus.FLAG, 0);
    }

    public static CellSnapshot ofLandMine(){
        return new CellSnapshot(CellSnapshotStatus.LAND_MINE, 0);
    }

    public static CellSnapshot ofNumber(int nearbyMineCount){
        return new CellSnapshot(CellSnapshotStatus.EMPTY, nearbyMineCount);
    }

    public static CellSnapshot ofUnchecked(){
        return new CellSnapshot(CellSnapshotStatus.UNCHECKED, 0);
    }

    public CellSnapshotStatus getStatus() {
        return status;
    }

    public int getNearbyMineCount() {
        return nearbyMineCount;
    }

    public boolean isSameStatus(CellSnapshotStatus cellSnapshotStatus){
        return this.status == cellSnapshotStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CellSnapshot snapshot = (CellSnapshot) o;
        return nearbyMineCount == snapshot.nearbyMineCount && status == snapshot.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, nearbyMineCount);
    }
}
