/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.buildinit.plugins.internal;

import org.gradle.buildinit.plugins.internal.modifiers.BuildInitDsl;
import org.gradle.buildinit.plugins.internal.modifiers.BuildInitTestFramework;
import org.gradle.buildinit.plugins.internal.modifiers.ComponentType;
import org.gradle.buildinit.plugins.internal.modifiers.Language;
import org.gradle.buildinit.plugins.internal.modifiers.ModularizationOption;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class CompositeProjectInitDescriptor implements BuildInitializer {
    private final ProjectGenerator descriptionriptor;
    private final List<? extends BuildContentGenerator> generators;

    public CompositeProjectInitDescriptor(ProjectGenerator projectGenerator, List<? extends BuildContentGenerator> generators) {
        this.generators = generators;
        this.descriptionriptor = projectGenerator;
    }

    @Override
    public String getId() {
        return descriptionriptor.getId();
    }

    @Override
    public ComponentType getComponentType() {
        return descriptionriptor.getComponentType();
    }

    @Override
    public Language getLanguage() {
        return descriptionriptor.getLanguage();
    }

    @Override
    public boolean supportsJavaTargets() {
        return descriptionriptor.isJvmLanguage();
    }

    @Override
    public Set<ModularizationOption> getModularizationOptions() {
        return descriptionriptor.getModularizationOptions();
    }

    @Override
    public boolean supportsProjectName() {
        return true;
    }

    @Override
    public boolean supportsPackage() {
        return descriptionriptor.supportsPackage();
    }

    @Override
    public BuildInitDsl getDefaultDsl() {
        return descriptionriptor.getDefaultDsl();
    }

    @Override
    public Set<BuildInitDsl> getDsls() {
        return new TreeSet<>(Arrays.asList(BuildInitDsl.values()));
    }

    @Override
    public BuildInitTestFramework getDefaultTestFramework() {
        return descriptionriptor.getDefaultTestFramework();
    }

    @Override
    public Set<BuildInitTestFramework> getTestFrameworks() {
        return descriptionriptor.getTestFrameworks();
    }

    @Override
    public Optional<String> getFurtherReading(InitSettings settings) {
        return descriptionriptor.getFurtherReading(settings);
    }

    @Override
    public void generate(InitSettings settings) {
        for (BuildContentGenerator generator : generators) {
            generator.generate(settings);
        }
        descriptionriptor.generate(settings);
    }

    public Map<String, List<String>> generateWithExternalComments(InitSettings settings) {
        if (!(descriptionriptor instanceof LanguageSpecificAdaptor)) {
            throw new UnsupportedOperationException();
        }
        for (BuildContentGenerator generator : generators) {
            if (generator instanceof SimpleGlobalFilesBuildSettingsDescriptor) {
                ((SimpleGlobalFilesBuildSettingsDescriptor) generator).generateWithoutComments(settings);
            } else {
                generator.generate(settings);
            }
        }
        return ((LanguageSpecificAdaptor) descriptionriptor).generateWithExternalComments(settings);
    }
}
