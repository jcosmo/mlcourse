class SimpleLayout < Layout::Default
  def initialize
    super()
    self[:target, :generated] = "generated"
  end
end

def define_with_central_layout(name, options = {}, &block)
  options = options.dup
  options[:layout] = SimpleLayout.new
  options[:base_dir] = "#{name}"

  define(name, options) do
    project.instance_eval &block
    project.clean { rm_rf _(:target, :generated) }
    project
  end
end

desc "MLCourse: An implementation of stuff for the stanford ML Course, and an excuse to experiment with GWT"
define 'mlcourse' do
  project.version = '1.0-SNAPSHOT'
  project.group = 'au.id.jwalker'

  iml.main_source_directories << _("client/src/main/java")

  compile.options.source = '1.6'
  compile.options.target = '1.6'
  compile.options.lint = 'all'

  iml.add_gwt_facet("/mlcourse" => "au.id.jwalker.mlcourse.mlcourse")
  compile.with :gwt_user, :javax_annotation, :google_guice, :aopalliance, :google_guice_assistedinject, :javax_inject, :gwt_gin
  test.with :easymock

  iml.add_web_facet( :webroot => 'web/src/main/webapp' )
  gwt_module = gwt(["au.id.jwalker.mlcourse.mlcourse"],
                       :dependencies => [compile.dependencies,
                                         # The following picks up both the jar and sources
                                         # packages deliberately. It is needed for the
                                         # generators to access classes in annotations.
                                         # Validation needed to quieten warnings from gwt compiler
                                         :javax_validation,
                                         :javax_validation_sources],
                       :java_args => ["-Xms512M", "-Xmx512M", "-XX:PermSize=128M", "-XX:MaxPermSize=256M"],
                       :draft_compile => (ENV["FAST_GWT"] == 'true'))

  package(:war).tap do |war|
    war.include "#{gwt_module}/WEB-INF"
    war.include "#{gwt_module}/mlcourse"
    war.with :libs => [:gwt_user, :gwt_dev]
    war.enhance [gwt_module]
  end

  # Remove the IDEA generated artifacts
  project.clean { rm_rf project._(:artifacts) }

  doc.using :javadoc, { :tree => false, :since => false, :deprecated => false, :index => false, :help => false }

  ipr.add_exploded_war_artifact(project,
                                :name => 'mlcourse',
                                :enable_gwt => true,
                                :war_module_names => [iml.id],
                                :gwt_module_names => [iml.id],
                                :dependencies => [:gwt_user, :gwt_dev, compile.dependencies, project])

  ipr.add_gwt_configuration("mlcourse.html", project, :shell_parameters => "-port 7888")
end
