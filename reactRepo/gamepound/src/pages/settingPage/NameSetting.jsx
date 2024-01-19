import { useState } from "react";

const NameSetting = ({loginMemberVo}) => {

    console.log(loginMemberVo);
    const [profile, setProfile] = useState();

    const baseURL = process.env.REACT_APP_API_URL;

    const handleName = (e)=>{
        console.log("handleName > e ::: ", e.target.value);
    }


    return (
        <>
            <div>이름</div>
            <div><input type="text" value={loginMemberVo.name} onChange={(e)=>{handleName(e)}}/></div>
            <div>
                <button>저장</button>
            </div>
        </>
    );
};

export default NameSetting;