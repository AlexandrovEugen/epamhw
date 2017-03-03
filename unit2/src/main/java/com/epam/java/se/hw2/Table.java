package com.epam.java.se.hw2;



import com.epam.java.se.hw2.tools.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table {


    private final List<Pen> pens = new ArrayList<>();
    private final List<Pencil> pencils = new ArrayList<>();
    private final List<Cutter> cutters = new ArrayList<>();
    private final List<PackOfStickers> packOfStickers = new ArrayList<>();
    private final List<Stapler> staplers = new ArrayList<>();
    private final List<HolePuncher> holePunchers = new ArrayList<>();
    private final List<PackOfDrawingPins> pins = new ArrayList<>();
    private final List<PackOfClips> packOfClips = new ArrayList<>();
    private final List<AdhesiveTape> adhesiveTapes = new ArrayList<>();
    private final List<PencilSharpener> pencilSharpeners = new ArrayList<>();


    public void addPen(int diameterOfRod, String color, String type, long cost) {
        pens.add(new Pen(diameterOfRod, color, type, cost));
    }

    public void addPencil(int diameterOfSlatePencil, String type,  long cost) {
        pencils.add(new Pencil(diameterOfSlatePencil, type, cost));
    }

    public void addCutter(int amountOfBlades, String type, long cost) {
        cutters.add(new Cutter(amountOfBlades, type, cost));
    }

    public void addPackOfStickers(int amountInThePack, String color, long cost) {
        packOfStickers.add(new PackOfStickers(amountInThePack, color, cost));
    }

    public void addStapler(String color, long cost) {
        staplers.add(new Stapler(color, cost));
    }

    public void addHolePuncher(String type, long cost) {
        holePunchers.add(new HolePuncher(type, cost));
    }

    public void addPackOfDrawingPins(int amountInThePack,String type, long cost) {
        pins.add(new PackOfDrawingPins(amountInThePack, type, cost));
    }

    public void addPackOfPaperClips(int amountInThePack, long cost) {
        packOfClips.add(new PackOfClips(amountInThePack, cost));
    }

    public void addPencilSharpener(String type, long cost) {
        pencilSharpeners.add(new PencilSharpener(type, cost));
    }

    public void addAdhesiveTape(int length, String type, long cost) {
        adhesiveTapes.add(new AdhesiveTape(length, type, cost));
    }

    public boolean isAllWorksFine() {
        return findNotWorkingToolsInEachList();
    }

    private boolean findNotWorkingToolsInEachList() {
        List<Pen> uselessPens = pens.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<Pencil> uselessPencils = pencils.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<Cutter> uselessCutters = cutters.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<PackOfStickers> uselessStickers = packOfStickers.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<Stapler> uselessStaplers = staplers.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<HolePuncher> uselessHolePunchers = holePunchers.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<PackOfDrawingPins> uselessPins = pins.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<PackOfClips> uselessClips = packOfClips.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<AdhesiveTape> uselessAdhesiveTapes = adhesiveTapes.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        List<PencilSharpener> uselessPencilSharpeners = pencilSharpeners.stream().filter(o -> !o.isUsable()).collect(Collectors.toList());
        return uselessPens.isEmpty() && uselessPencils.isEmpty() && uselessCutters.isEmpty()
                && uselessStickers.isEmpty() && uselessStaplers.isEmpty() && uselessHolePunchers.isEmpty()
                && uselessPins.isEmpty() && uselessClips.isEmpty() && uselessAdhesiveTapes.isEmpty() && uselessPencilSharpeners.isEmpty();
    }


    public long totalSumOfOfficeTools() {
        return sumForEachList();
    }

    private long sumForEachList() {
        long sumOfPens = 0L;
        if (!pens.isEmpty()){
            sumOfPens = pens.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfPencils = 0L;
        if (!pencils.isEmpty()){
            sumOfPencils = pencils.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfcutters = 0L;
        if (!cutters.isEmpty()){
            sumOfcutters = cutters.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfPackOfStickers = 0L;
        if (!packOfStickers.isEmpty()){
            sumOfPackOfStickers = packOfStickers.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfStaplers = 0L;
        if (!staplers.isEmpty()){
            sumOfStaplers = staplers.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfHolePunchers = 0L;
        if (!holePunchers.isEmpty()){
            sumOfHolePunchers = holePunchers.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfPins = 0L;
        if (!pins.isEmpty()){
            sumOfPins = pins.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfPackOfClips = 0L;
        if (!packOfClips.isEmpty()){
            sumOfPackOfClips = packOfClips.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfAdhesiveTapes = 0L;
        if (!adhesiveTapes.isEmpty()){
            sumOfAdhesiveTapes = adhesiveTapes.stream().mapToLong(o -> o.getCost()).sum();
        }
        long sumOfPencilSharpeners = 0L;
        if (!pencilSharpeners.isEmpty()){
            sumOfPencilSharpeners = pencilSharpeners.stream().mapToLong(o -> o.getCost()).sum();
        }
        return sumOfPens + sumOfPencils + sumOfcutters + sumOfPackOfStickers + sumOfStaplers +
                sumOfHolePunchers + sumOfPackOfClips + sumOfPins + sumOfPencilSharpeners + sumOfAdhesiveTapes;
    }
}
