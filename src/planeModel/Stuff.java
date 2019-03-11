package planeModel;

public class Stuff {
    public boolean notebook;
    public boolean notepad;
    public boolean pen;

    public Stuff(boolean notebook, boolean notepad, boolean pen) {
        this.notebook = notebook;
        this.notepad = notepad;
        this.pen = pen;
    }

    public int getNotebook() {
        if(notebook) return 1;
        else return 0;
    }

    public int getNotePad() {
        if(notebook) return 1;
        else return 0;
    }

    public int getPen() {
        if(notebook) return 1;
        else return 0;
    }
}
