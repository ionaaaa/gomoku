import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;
import java.util.Vector;

public class Undo {
    boolean inProgress; // if haven't end
    protected Vector<UndoableEdit> edits; // the array of edits

    public void Undo() throws CannotUndoException {
//        super.undo();  //dunno what it is
        int i = edits.size();
        while (i-- > 0) {
            UndoableEdit e = edits.elementAt(i);
            e.undo();
        }
    }

    public synchronized boolean addEdit(UndoableEdit e){
        boolean retVal;
        trimEdits(indexOfNextAdd, edits.size() - 1); //there may be a parent class

        retVal = super.addEdit(e);
        if (inProgress){
            retVal = true;
        }

        indexOfNextAdd = edits.size();

        trimForLimit();

        return retVal;
    }

    public synchronized void Undo() throws CannotUndoException{
        if (inProgress){
            UndoableEdit edit = editToBeUndone();
            if (edit == null){
                throw new CannotUndoException();
            }
            undoTo(edit);
        }else super.undo();
    }

    public synchronized String getUndoPresentationName(){
        if (inProgress){
            if (canUndo()){
                return editToBeUnDone().getUndoPresentationName;
            }else return UIManager.getString("AbstractUndoableEdit.undoText");
        }else return super.getUndoPresentationName();
    }

}
