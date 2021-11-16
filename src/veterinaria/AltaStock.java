package veterinaria;

import java.io.Serializable;

public class AltaStock implements Serializable {

    private StockProductos sp;

    public StockProductos getSp() {
        return sp;
    }

    public void setSp(StockProductos sp) {
        this.sp = sp;
    }

}
