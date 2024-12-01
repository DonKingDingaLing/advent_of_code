# Define the base directory
$year = (Get-Date).Year
$baseDir = "aoc-$year"

# Create the base directory
New-Item -ItemType Directory -Path $baseDir

# Loop to create 25 day folders
for ($i = 1; $i -le 25; $i++) {
    $dayDir = "$baseDir\day_$i"
    New-Item -ItemType Directory -Path $dayDir

    # Create challenge_1 and challenge_2 folders within each day folder
    for ($j = 1; $j -le 2; $j++) {
        $challengeDir = "$dayDir\challenge_$j"
        New-Item -ItemType Directory -Path $challengeDir

        # Create rust_workspace and java_workspace folders within each challenge folder
        $rustChallengeRoot = "$challengeDir\rust_workspace"
        $rustChallengeSrc = "$rustChallengeRoot\src"
        $rustChallengeTests = "$rustChallengeRoot\tests"
        New-Item -ItemType Directory -Path "$rustChallengeSrc"
        New-Item -ItemType Directory -Path "$rustChallengeTests"

                $rustSrcContent = @"
fn main() {
    println!("Start here");
}
"@
        New-Item $rustChallengeSrc\challenge$($j)_day$($i).rs -ItemType File -Value $rustSrcContent

                        $rustTestContent = @"
#[test]
fn test_challenge() {
    assert_eq!(
        true,
        true
    );
}
"@
        New-Item $rustChallengeTests\challenge$($j)_day$($i)_test.rs -ItemType File -Value $rustTestContent

        $javaChallengeRoot = "$challengeDir\java_workspace"
        $javaChallengeSrc = "$javaChallengeRoot\src\main\java"
        $javaChallengeTests = "$javaChallengeRoot\src\test\java"
        New-Item -ItemType Directory -Path "$javaChallengeSrc"
        New-Item -ItemType Directory -Path "$javaChallengeTests"

        $javaSrcContent = @"
public class Challenge$($j)Day$($i) {
    public static void main(String[] args) {
        System.out.println("Start here!");
    }
}
"@
        New-Item $javaChallengeSrc\Challenge$($j)Day$($i).java -ItemType File -Value $javaSrcContent

        $javaTestContent = @"
public class Challenge$($j)Day$($i)Test {
    @Test
    testChallenge() {
        assertTrue(false);
    }
}
"@
        New-Item $javaChallengeTests\Challenge$($j)Day$($i)Test.java  -ItemType File -Value $javaTestContent

    }
}

Write-Output "Directory structure created successfully!"
