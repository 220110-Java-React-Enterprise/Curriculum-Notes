public class InjectMe {
    private Thingy thingy;

    @Autowired
    public InjectMe(Thingy thingy) {
        this.thingy = thingy;
    }
}
