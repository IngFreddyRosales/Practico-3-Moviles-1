import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practico_3_moviles_1.databinding.ItemLikedFragmentBinding
import com.example.practico_3_moviles_1.model.Profile

class LikedProfilesAdapter : RecyclerView.Adapter<LikedProfilesAdapter.LikedProfileViewHolder>() {

    private var profiles: List<Profile> = listOf()


    class LikedProfileViewHolder(private val binding: ItemLikedFragmentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: Profile) {
            binding.profileName.text = profile.name
            binding.profileImage.setImageResource(profile.images.first())
            print("clase LikedProfileViewHolder")
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedProfileViewHolder {
        val binding = ItemLikedFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LikedProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LikedProfileViewHolder, position: Int) {
        holder.bind(profiles[position])
    }

    override fun getItemCount(): Int {
        return profiles.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(profileList: List<Profile>) {
        profiles = profileList
        notifyDataSetChanged()
    }
}
