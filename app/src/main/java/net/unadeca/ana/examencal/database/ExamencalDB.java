package net.unadeca.ana.examencal.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by ANA on 08/04/2018.
 */
@Database(name= ExamencalDB.NAME, version = ExamencalDB.VERSION)
public class ExamencalDB {
    public static final String NAME="Examencal";
    public static final int VERSION=1;
}.getText().toString();

        int int1=Integer.parseInt(Cifra1);
        int int2=Integer.parseInt(Cifra2);

        int rta=0;

        switch (v.getId()){
        case R.id.s:
        rta=int1+int2;
        result = rta;
        signo="+";
        guardar();
        break;
        case R.id.r:
        rta=int1-int2;
        signo="-";
        guardar();
        break;
        case R.id.m:
        rta=int1*int2;
        signo="*";
        guardar();
        break;
        case R.id.d:
        rta=int1/int2;
        signo="/";
        guardar();
        break;
        }
        resultado.setText(""+rta);
}
private void guardar(){
        CalculadoraTable registro = new CalculadoraTable();
        registro.integer1 =n1.getText().toString();
        registro.integer2 = n2.getText().toString();
        registro.operador = signo;
        registro.resultado = result;
        registro.save();
        }
}


