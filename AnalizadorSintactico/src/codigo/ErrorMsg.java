/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author pablo
 */
public class ErrorMsg {
    private final String msg;
    private final String token;
    private final int row;
    private final int  column;

    public ErrorMsg(String ptoken, String pMsg,  int pRow, int pColumn) {
        this.token = ptoken;
        this.msg = pMsg;
        this.row = pRow;
        this.column = pColumn;
    }
    
    String getError() {
        return this.msg + " near: "  + this.token + ":"+ this.row + ":" + this.column;
    }
}
