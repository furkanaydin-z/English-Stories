package com.example.englishbook.uı.fragment


/*class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
    lateinit var auth:FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater,container,false)

        auth = FirebaseAuth.getInstance()
        binding.logInButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.logToList)
        }

        binding.buttonSignIntoLogIn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.logToSignUp)
        }

        binding.logInButton.setOnClickListener {
            val email = binding.textInputName.editText?.text.toString()
            val password = binding.textInputPassword.editText?.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.logToList)
                    } else {
                        // Giriş başarısız olduğunda yapılacak işlemler
                        Toast.makeText(requireContext(), "Login failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        return binding.root
    }
}*/