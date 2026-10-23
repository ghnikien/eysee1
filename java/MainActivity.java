public class MainActivity extends AppCompatActivity {
    
    // Provide the following: MY_USERNAME and MY_DISPLAY_NAME
    private static final String MY_USERNAME = //Insert your username;
    private static final String MY_DISPLAY_NAME = //Insert your display name;

    // Declare the Views needed
    private RecyclerView tweetRv;
    private FloatingActionButton addTweetFab;
    private ArrayList<Tweet> tweets;
    private TweetAdapter tweetAdapter;

    // Receives the caption sent back by AddTweetActivity
    private ActivityResultLauncher<Intent> addTweetLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // Only add a tweet if the user pressed "Tweet" (not Cancel or Back)
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        String caption = result.getData().getStringExtra(AddTweetActivity.CAPTION_KEY);

                        // 2nd constructor: likes = 0, image = myimage, date = today
                        Tweet newTweet = new Tweet(MY_USERNAME, MY_DISPLAY_NAME, caption);

                        // Put the new tweet at the TOP of the list
                        tweets.add(0, newTweet);
                        tweetAdapter.notifyItemInserted(0);
                        tweetRv.scrollToPosition(0);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Step 1. Get the Data
       

        // Step 2. Find the RecyclerView
        

        // Step 3. Tell how it arranges the rows
        

        // Step 4. Give the Adapter
       

        // Step 5. FloatingActionButton opens the Add Tweet screen
       
    }
}