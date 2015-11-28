package apk.teste.com.projetolistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.RadioGroup;



public class MainActivity extends Activity {
    private ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] pragas = {
                "Barata Germânica",
                "Barata Americana",
                "Carrapatos",
                "Cupim / Brocas",
                "Escorpiões",
                "Formigas",
                "Morcegos",
                "Moscas",
                "Mosquitos",
                "Mus Muscullus",
                "Pulgas",
                "Traças",
                "Rattus Norvegicus",
                "Rattus Rattus",
                "Supella Longipalpa",
                "Arachnida Araneae" };

        Option weather_data[] = new Option[]{

            new Option("Barata Germânica"),
            new Option("Barata Americana"),
            new Option("Carrapatos"),
            new Option("Cupim / Brocas"),
            new Option("Escorpiões"),
            new Option("Formigas"),
            new Option("Morcegos"),
            new Option("Moscas"),
            new Option("Mosquitos"),
            new Option("Mus Muscullus"),
            new Option("Pulgas"),
            new Option("Traças"),
            new Option("Rattus Norvegicus"),
            new Option("Rattus Rattus"),
            new Option("Supella Longipalpa"),
            new Option("Arachnida Araneae")

           /* new MatrixOption("Heading1"),
            new MatrixOption("Heading2"),
            new MatrixOption("Heading3"),
            new MatrixOption("Heading4"),
            new MatrixOption("Heading5")*/
        };

        RadioGroupAdapter adapter = new RadioGroupAdapter(this,
                R.layout.listitem, weather_data);
        listView1 = (ListView)findViewById(R.id.list);
        listView1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.activity_main, menu);
        return true;
    }

}
