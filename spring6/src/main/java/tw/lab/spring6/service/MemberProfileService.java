package tw.lab.spring6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.lab.spring6.entity.Member;
import tw.lab.spring6.entity.Profile;
import tw.lab.spring6.repository.MemberRepository;
import tw.lab.spring6.repository.ProfileRepository;

@Service
public class MemberProfileService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private ProfileRepository profileRepository;
	
	@Transactional
	public Member save(Member member, Profile profile) {
		member.setProfile(profile);
		return memberRepository.save(member);
	}
	
	@Transactional
	public Profile setProfileToMember(Long memberId, Profile profile) {
		Member member = memberRepository.findById(memberId).orElse(null);
		if (member != null) {
			Profile mp = member.getProfile();
			if (mp != null) {
				profile.setId(mp.getId());
			}
			member.setProfile(profile);
			return memberRepository.save(member).getProfile();
		}else {
			return null;
		}
	}
	
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId).orElse(null);
	}
	
	@Transactional
	public void deleteMember(Long memberId) {
		memberRepository.deleteById(memberId);
	}
	
}