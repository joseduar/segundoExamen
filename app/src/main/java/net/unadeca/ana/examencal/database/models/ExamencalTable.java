package net.unadeca.ana.examencal.database.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by ANA on 08/04/2018.
 */
@Table(database = ExamencalTable.class)
public class ExamencalTable extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;
    @Column
    public  String integer1;
    @Column
    public String operador;
    @Column
    public  String integer2;
    @Column
    public int resultado;
}
