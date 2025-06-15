package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapshot;

import java.util.List;

public class CellSignFinder {
    public static final List<CellSignProvidable> CELL_SIGN_PROVIDERS = List.of(
            new EmptyCellSignProvider(),
            new FlagCellSignProvider(),
            new LandMineCellSignProvider(),
            new NumberCellSignProvider(),
            new UncheckedCellSignProvider()
    );

    public String findeCellSignFrom(CellSnapshot cellSnapshot){
        return CELL_SIGN_PROVIDERS.stream()
                .filter(cellSignProvidable -> cellSignProvidable.supports(cellSnapshot))
                .findFirst()
                .map(cellSignProvidable -> cellSignProvidable.provide(cellSnapshot))
                .orElse("");
    }
}
