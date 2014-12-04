package com.framework.project.config;

import java.util.Arrays;
import java.util.List;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import com.framework.project.classes.Test;


public class Configuration extends JUnitStories {

	@Override
	public org.jbehave.core.configuration.Configuration configuration() {

		final MostUsefulConfiguration configuration = new MostUsefulConfiguration();

		configuration.storyReporterBuilder()
		.withFormats( Format.CONSOLE, Format.STATS, Format.HTML ) 
		.withFailureTrace(true) //
		.withMultiThreading(true);


		configuration.storyControls().doSkipScenariosAfterFailure(false).doResetStateBeforeStory(true);
		return configuration;  

	}


	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(),new Test());

	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
				Arrays.asList("**/*.story"), null);
	}

}
