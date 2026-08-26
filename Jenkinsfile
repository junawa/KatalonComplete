pipeline {
    agent { label 'windows-katalon' }
    options { timestamps(); timeout(time: 15, unit: 'MINUTES') }
    parameters {
        choice(name: 'SUITE', choices: ['TS_BVT', 'TS_REG_SMOKE', 'TS_REG_FUNCTIONAL', 'TS_REG_FULL'], description: 'Katalon suite to execute')
        choice(name: 'PROFILE', choices: ['QA', 'UAT', 'STAGING'], description: 'Execution profile')
    }
    environment { KATALON_HOME = credentials('katalon-runtime-home') }
    stages {
        stage('Checkout') { steps { checkout scm } }
        stage('Execute Katalon') {
            steps {
                withCredentials([string(credentialsId: 'katalon-api-key', variable: 'KATALON_API_KEY')]) {
                    bat '''"%KATALON_HOME%\\katalonc.exe" -noSplash -runMode=console -retry=0 -projectPath="%WORKSPACE%\\KatalonProj.prj" -testSuitePath="Test Suites/%SUITE%" -browserType="Edge Chromium" -executionProfile="%PROFILE%" -apiKey="%KATALON_API_KEY%" --config -webui.autoUpdateDrivers=true'''
                }
            }
        }
    }
    post {
        always { archiveArtifacts artifacts: 'Reports/**', allowEmptyArchive: true }
    }
}
