package pl.dawidfiruzek.retrofitexample;

import java.util.List;

import pl.dawidfiruzek.retrofitexample.api.GitHubService;
import pl.dawidfiruzek.retrofitexample.api.Repository;
import pl.dawidfiruzek.retrofitexample.api.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dawid Firuzek on 05.09.16.
 */
public class MainPresenter {
    private final MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void onResumed() {
        final String user = "dawidfiruzek";

        ServiceGenerator.createService(GitHubService.class).getRepositories(user).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                StringBuilder sb = new StringBuilder();
                sb.append("List of repos for ");
                sb.append(user);
                sb.append(":\n");

                for (Repository repo : response.body()) {
                    sb.append(repo.getName());
                    sb.append("\n");
                }

                view.showRepos(sb.toString());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {

            }
        });
    }
}
