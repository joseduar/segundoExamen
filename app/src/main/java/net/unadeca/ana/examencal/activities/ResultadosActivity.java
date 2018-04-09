package net.unadeca.ana.examencal.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import net.unadeca.ana.examencal.R;
import net.unadeca.ana.examencal.database.ExamencalApp;
import net.unadeca.ana.examencal.database.models.ExamencalTable;
import net.unadeca.ana.examencal.subclases.ExamencalViewHolder;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;

import java.util.List;

/**
 * Created by ANA on 08/04/2018.
 */

public enum ResultadosActivity extends AppCompatActivity {
    private static Context QuickContext;
    private RecyclerView lista;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historialver);
       QuickContext = this;

       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    lista = findViewById(R.id.lista);
       lista.setLayoutManager(new LinearLayoutManager(this));
      List<ExamencalTable>info = SQLite.select().from(ExamencalTable.class).queryList();
      lista.setAdapter(new ExamencalApp(info));
      // }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            List<ExamencalTable> info = SQLite.select().from(ExamencalTable.class).queryList();
            lista.setAdapter(new ExamencalAdapter(info));
        }
        return super.onOptionsItemSelected(item);
    }
    public static class ExamencalApp extends RecyclerView.Adapter<ExamencalViewHolder> {
        private final List<ExamencalTable> listExamencalTable;
        private final LayoutInflater inflater;

        public ExamencalApp(List<ExamencalTable> listToDoTables) {
            this.inflater = LayoutInflater.from(QuickContext);
            this.listExamencalTable = listToDoTables;
        }
        @Override
        public ExamencalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.objecto, parent, false);
            return new ExamencalViewHolder(view);
        }
        public void animateTo(List<ExamencalTable> models) {
            applyAndAnimateRemovals(models);
            applyAndAnimateAdditions(models);
            applyAndAnimateMovedItems(models);
        }

        private void applyAndAnimateRemovals(List<ExamencalTable> newModels) {
            for (int i = listExamencalTable.size() - 1; i >= 0; i--) {
                final ExamencalTable model = ExamencalTable.get(i);
                if (!newModels.contains(model)) {
                    removeItem(i);
                }
            }
        }

        private void applyAndAnimateAdditions(List<ExamencalTable> newModels) {
            for (int i = 0, count = newModels.size(); i < count; i++) {
                final ExamencalTable model = newModels.get(i);
                if (!listExamencalTable.contains(model)) {
                    addItem(i, model);
                }
            }
        }

        private void applyAndAnimateMovedItems(List<ExamencalTable> newModels) {
            for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
                final ExamencalTable model = newModels.get(toPosition);
                final int fromPosition = ExamencalTable.indexOf(model);
                if (fromPosition >= 0 && fromPosition != toPosition) {
                    moveItem(fromPosition, toPosition);
                }
            }
        }

        public ExamencalTable removeItem(int position) {
            final ExamencalTable model = listExamencalTable.remove(position);
            notifyItemRemoved(position);
            return model;
        }

        public void addItem(int position, ExamencalTable model) {
            listExamencalTable.add(position, model);
            notifyItemInserted(position);
        }

        public void moveItem(int fromPosition, int toPosition) {
            final ExamencalTable model = listExamencalTable.remove(fromPosition);
            listExamencalTable.add(toPosition, model);
            notifyItemMoved(fromPosition, toPosition);
        }
        @Override
        public void onBindViewHolder(final ExamencalViewHolder holder, final int position) {
            final ExamencalTable current = listExamencalTable.get(position);
            holder.html.setHtml(ActividadAString(current),
                    new HtmlResImageGetter(holder.html));
            holder.html.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                }
            });

        }
        private  String ActividadAString(ExamencalTable todo){
            String html= "<a><big><b> <font color =\""+"\">"+todo.integer1+todo.operador+todo.integer2+"="+todo.resultado + "</b></big>";
            return html;
        }
        @Override
        public int getItemCount() {
            return listExamencalTable.size();
        }

    }
}
