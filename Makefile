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