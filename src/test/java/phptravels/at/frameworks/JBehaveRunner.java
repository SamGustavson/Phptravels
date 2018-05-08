package phptravels.at.frameworks;

import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.junit.JUnitStories;
import org.junit.Test;
import org.junit.runner.RunWith;
import phptravels.at.steps.PhptravelsSteps;

import java.util.List;

@RunWith(value=AnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder=Embedder.class)
//@Configure( storyReporterBuilder=MyReporter.class, storyLoader=MyStoryLoader.class)
@UsingSteps(instances={ PhptravelsSteps.class })

public class JBehaveRunner extends JUnitStories {

    @Test
    @Override
    public void run() throws Throwable {

        // finding stories and running them
        new PhptravelsSteps();

    }

    @Override
    protected List<String> storyPaths() {
        return null;
    }

}