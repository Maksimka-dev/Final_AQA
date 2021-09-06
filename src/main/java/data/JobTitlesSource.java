package data;

import utils.ConfProperties;
import value_objects.JobTitle;

import java.util.Arrays;
import java.util.List;

public class JobTitlesSource {
    public static List<JobTitle> jobTitlesSourceList(){
        return Arrays.asList(
                new JobTitle(ConfProperties.getProperty("job_title_1")),
                new JobTitle(ConfProperties.getProperty("job_title_2")),
                new JobTitle(ConfProperties.getProperty("job_title_3"))
        );
    }
}
