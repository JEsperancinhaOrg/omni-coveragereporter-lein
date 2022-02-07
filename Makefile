coverage:
	lein with-profiles +coverage cloverage --lcov
build:
	lein deps
	lein install
	lein test
	lein with-profiles +coverage cloverage --lcov
	lein with-profiles +run omni-coveragereporter-lein
run:
	lein with-profiles +run omni-coveragereporter-lein
update-local:
	rm -rf maven_repository
	mkdir -p maven_repository
	mkdir -p maven_repository/org
	mkdir -p maven_repository/org/jesperancinha
	 cp -r ~/.m2/repository/org/jesperancinha/plugins maven_repository/org/jesperancinha
