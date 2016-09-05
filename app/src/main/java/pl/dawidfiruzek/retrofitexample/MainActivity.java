package pl.dawidfiruzek.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.main_repositories)
    TextView repositories;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.onResumed();
    }

    @Override
    public void showRepos(String repos) {
        repositories.setText(repos);
    }
}
