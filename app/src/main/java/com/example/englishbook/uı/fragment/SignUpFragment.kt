package com.example.englishbook.uı.fragment


/*class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        auth = FirebaseAuth.getInstance()


        binding.buttonSGnUp.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.signToLogIn)
        }

        binding.buttonSGnUp.setOnClickListener {
            val email = binding.signUpTextInputGmail.editText?.text.toString()
            val password = binding.signUpTextInputPassword.editText?.text.toString()
            val confirmPassword = binding.signUpTextInputConfirmPassword.editText?.text.toString()
            if (email.isEmpty()|| password.isEmpty()|| confirmPassword.isEmpty()){
                Snackbar.make(it,"Please fill in the empty boxes",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != confirmPassword){
                Snackbar.make(it,"Passwords are not the same",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(requireActivity()) {
                    if (it.isSuccessful){
                        Toast.makeText(requireContext(), "Kayıt başarıyla tamamlandı", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.signToLogIn)

                    }else{
                        val errorMessage = it.exception?.message
                        Toast.makeText(requireContext(), "Error : $errorMessage", Toast.LENGTH_SHORT).show()

                    }

                }
        }
        return binding.root
    }
}*/