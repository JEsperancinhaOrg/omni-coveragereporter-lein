(ns leiningen.omni-coveragereporter-lein
  (:require [cheshire.core :as json]
            [clojure.core]
            [clojure.java.io :as io]
            [clojure.test :refer [is]])
  (:import (java.io File FileReader)
           (java.util ArrayList List)
           (org.jesperancinha.plugins.omni.reporter.pipelines Pipeline PipelineImpl)
           (org.jesperancinha.plugins.omni.reporter.processors CoverallsReportsProcessor)))

(def banner (io/resource
              "banner.txt"))

(defn omni-coveragereporter-lein
  "Omni Coverage Plugin For Leiningen Repos.
  Check https://leiningen.org/ for further details on how to use these repos"
  [_ & _]
  (println (.getCanonicalPath (clojure.java.io/file ".", "omni-config.json")))
  (println (slurp banner))
  (println "* Starting reporting...")
  (let [
        config-file (.getCanonicalPath (clojure.java.io/file ".", "omni-config.json"))
        base-dir (.getCanonicalPath (clojure.java.io/file "."))
        configuration (slurp (FileReader. config-file))
        json-config (json/decode configuration true)
        coverallsUrl (get-in json-config [:coverallsUrl])
        codacyUrl (get-in json-config [:codacyUrl])
        codecovUrl (get-in json-config [:codecovUrl])
        sourceEncoding (get-in json-config [:sourceEncoding])
        projectBaseDir (get-in json-config [:projectBaseDir])
        failOnNoEncoding (get-in json-config [:failOnNoEncoding])
        failOnUnknown (get-in json-config [:failOnUnknown])
        failOnReportNotFound (get-in json-config [:failOnReportNotFound])
        failOnReportSendingError (get-in json-config [:failOnReportSendingError])
        failOnXmlParsingError (get-in json-config [:failOnXmlParsingError])
        disableCoveralls (get-in json-config [:disableCoveralls])
        disableCodacy (get-in json-config [:disableCodacy])
        disableCodecov (get-in json-config [:disableCodecov])
        ignoreTestBuildDirectory (get-in json-config [:ignoreTestBuildDirectory])
        useCoverallsCount (get-in json-config [:useCoverallsCount])
        branchCoverage (get-in json-config [:branchCoverage])
        fetchBranchNameFromEnv (get-in json-config [:fetchBranchNameFromEnv])
        coverallsToken (or (get-in json-config [:coverallsToken] (or (System/getenv "COVERALLS_REPO_TOKEN") (System/getenv "COVERALLS_TOKEN"))))
        codecovToken (or (get-in json-config [:codecovToken] (System/getenv "CODECOV_TOKEN")))
        codacyToken (or (get-in json-config [:codacyToken] (System/getenv "CODACY_PROJECT_TOKEN")))
        codacyApiToken (or (get-in json-config [:codacyApiToken] (System/getenv "CODACY_API_TOKEN")))
        codacyOrganizationProvider (or (get-in json-config [:codacyOrganizationProvider] (System/getenv "CODACY_ORGANIZATION_PROVIDER")))
        codacyUserName (or (get-in json-config [:codacyUserName] (System/getenv "CODACY_USERNAME")))
        codacyProjectName (or (get-in json-config [:codacyProjectName] (System/getenv "CODACY_PROJECT_NAME")))
        extraSourceFolders (get-in json-config [:extraSourceFolder])
        extraReportFolders (get-in json-config [:extraReportFolders])
        reportRejectList (get-in json-config [:reportRejectList])
        currentPipeline (is (instance? Pipeline (PipelineImpl/currentPipeline (Boolean/valueOf fetchBranchNameFromEnv))))
        coverallsProcessor (is
                             (instance? CoverallsReportsProcessor
                                        (CoverallsReportsProcessor/createProcessor
                                                                                    (String/valueOf coverallsToken),
                                                                                    false,
                                                                                    (String/valueOf coverallsUrl) ,
                                                                                    base-dir,
                                                                                    base-dir,
                                                                                    (Boolean/valueOf failOnUnknown),
                                                                                    (Boolean/valueOf failOnReportNotFound),
                                                                                    (Boolean/valueOf failOnReportSendingError),
                                                                                    (Boolean/valueOf failOnXmlParsingError),
                                                                                    (Boolean/valueOf fetchBranchNameFromEnv),
                                                                                    (Boolean/valueOf branchCoverage),
                                                                                    (Boolean/valueOf ignoreTestBuildDirectory),
                                                                                    (Boolean/valueOf useCoverallsCount),
                                                                                    "",
                                                                                    ""
                                                                                    "")))
        ]
    (println (format "Coveralls URL: %s" coverallsUrl))
    (println (format "Codacy URL: %s" codacyUrl))
    (println (format "Codecov URL: %s" codecovUrl))
    (println (format "Coveralls token: %s" "checkToken(coverallsToken)"))
    (println (format "Codecov token: %s" "checkToken(codecovToken)"))
    (println (format "Codacy token: %s" "checkToken(codacyToken)"))
    (println (format "Codacy API token: %s" "checkToken(codacyApiToken)"))
    (println (format "Codacy API fully configured: %s" "this.isCodacyAPIConfigured"))
    (println (format "Source Encoding: %s" sourceEncoding))
    (println (format "Parent Directory: %s" projectBaseDir))
    (println (format "failOnNoEncoding: %s" failOnNoEncoding))
    (println (format "failOnUnknown: %s" failOnUnknown))
    (println (format "failOnReportNotFound: %s" failOnReportNotFound))
    (println (format "failOnReportSendingError: %s" failOnReportSendingError))
    (println (format "failOnXmlParsingError: %s" failOnXmlParsingError))
    (println (format "disableCoveralls: %s" disableCoveralls))
    (println (format "disableCodacy: %s" disableCodacy))
    (println (format "ignoreTestBuildDirectory: %s" ignoreTestBuildDirectory))
    (println (format "branchCoverage: %s" branchCoverage))
    (println (format "useCoverallsCount: %s" useCoverallsCount))
    (println (format "extraSourceFolders: %s" extraSourceFolders))
    (println (format "extraReportFolders: %s" extraReportFolders))
    (println (format "reportRejectList: %s" reportRejectList))
    )
  (println "* Reporting Finished!"))
