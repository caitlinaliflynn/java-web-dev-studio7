package org.launchcode.studio7;

public class CD extends BaseDisc {

    // TODO: Implement your custom interface.

    // TODO: Determine which fields, methods, and constructors can be extended from the base class and which ones
    //  need to be declared separately.

    private final String genre;
    private final String productionCompany;

    public CD(String title, String author, String discType, String genre, String productionCompany) {
        super(title, author, discType);
        this.genre = genre;
        this.productionCompany = productionCompany;
    }

    @Override
    public String toString() {
        StringBuilder fileList = new StringBuilder();
        for (File file : getFiles()) {
            fileList.append(file);
        }
        return super.toString() +
                "\nGenre: " + genre +
                "\nProduction Company: " + productionCompany +
                "\nTracks:\n" +
                fileList;
    }

    @Override
    public void readData() {
        System.out.println(this);
    }

    @Override
    public void runFile(File file) {
        System.out.println("\n" + file.getName() + getAuthor());
    }

    @Override
    public void writeData(File file) {
        if (!file.getFileType().equals("audio")) {
            System.out.println("The" + file.getFileType() + "file type cant be written to a CD");
        } else if (getSpaceUsed() + file.getSize() > CAPACITIES.get(getDiscType())) {
            System.out.println("There is not enough space on the " +
                    getDiscType() + " for " + file.getName());
        } else {
            getFiles().add(file);
        }
    }


}
